class Item {
    String name;
    String id;
    int quantity;
    double price;
    Item next;

    public Item(String id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class InventoryList {
    private Item head;

    // Add at beginning
    public void addAtBeginning(String id, String name, int quantity, double price) {
        Item newItem = new Item(id, name, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    // Add at end
    public void addAtEnd(String id, String name, int quantity, double price) {
        Item newItem = new Item(id, name, quantity, price);
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
    }

    // Add at specific position (1-based)
    public void addAtPosition(int position, String id, String name, int quantity, double price) {
        if (position <= 1) {
            addAtBeginning(id, name, quantity, price);
            return;
        }

        Item newItem = new Item(id, name, quantity, price);
        Item temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of bounds. Adding at end.");
            addAtEnd(id, name, quantity, price);
        } else {
            newItem.next = temp.next;
            temp.next = newItem;
        }
    }

    // Remove by Item ID
    public void removeById(String id) {
        if (head == null) return;
        if (head.id.equals(id)) {
            head = head.next;
            return;
        }

        Item prev = null, curr = head;
        while (curr != null && !curr.id.equals(id)) {
            prev = curr;
            curr = curr.next;
        }

        if (curr != null) {
            prev.next = curr.next;
        } else {
            System.out.println("Item not found.");
        }
    }

    // Update quantity by ID
    public void updateQuantity(String id, int quantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.id.equals(id)) {
                temp.quantity = quantity;
                System.out.println("Quantity updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    // Search by ID or name
    public void searchItem(String keyword) {
        Item temp = head;
        while (temp != null) {
            if (temp.id.equalsIgnoreCase(keyword) || temp.name.equalsIgnoreCase(keyword)) {
                System.out.println("Item Found: " + temp.name + " (ID: " + temp.id + "), Qty: " + temp.quantity + ", Price: " + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    // Calculate total value
    public void calculateTotalValue() {
        double total = 0;
        Item temp = head;
        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: ₹" + total);
    }

    // Sort by Name or Price
    public void sortInventory(String criteria, boolean ascending) {
        head = mergeSort(head, criteria, ascending);
    }

    private Item mergeSort(Item head, String criteria, boolean asc) {
        if (head == null || head.next == null) return head;

        Item middle = getMiddle(head);
        Item nextOfMiddle = middle.next;
        middle.next = null;

        Item left = mergeSort(head, criteria, asc);
        Item right = mergeSort(nextOfMiddle, criteria, asc);

        return sortedMerge(left, right, criteria, asc);
    }

    private Item getMiddle(Item head) {
        if (head == null) return head;
        Item slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private Item sortedMerge(Item a, Item b, String criteria, boolean asc) {
        if (a == null) return b;
        if (b == null) return a;

        boolean compare;
        if (criteria.equalsIgnoreCase("name")) {
            compare = asc ? a.name.compareToIgnoreCase(b.name) <= 0 : a.name.compareToIgnoreCase(b.name) > 0;
        } else {
            compare = asc ? a.price <= b.price : a.price > b.price;
        }

        Item result;
        if (compare) {
            result = a;
            result.next = sortedMerge(a.next, b, criteria, asc);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next, criteria, asc);
        }
        return result;
    }

    // Display all
    public void displayInventory() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        Item temp = head;
        System.out.println("Inventory Items:");
        while (temp != null) {
            System.out.println("ID: " + temp.id + ", Name: " + temp.name + ", Qty: " + temp.quantity + ", Price: ₹" + temp.price);
            temp = temp.next;
        }
    }
}
