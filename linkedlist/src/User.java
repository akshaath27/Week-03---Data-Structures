import java.util.ArrayList;

// Node class representing a user
class User {
    int userId;
    String name;
    int age;
    ArrayList<Integer> friendIds;
    User next;

    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
}

// Singly Linked List Class for Social Network
class SocialNetwork {
    private User head = null;

    // Add a new user
    public void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUser;
        }
    }

    // Search for a user by ID
    private User findUserById(int userId) {
        User current = head;
        while (current != null) {
            if (current.userId == userId) return current;
            current = current.next;
        }
        return null;
    }

    // Add friend connection between two users
    public void addFriend(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }
        if (!user1.friendIds.contains(userId2)) user1.friendIds.add(userId2);
        if (!user2.friendIds.contains(userId1)) user2.friendIds.add(userId1);
        System.out.println("Friend connection added.");
    }

    // Remove friend connection
    public void removeFriend(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);
        if (user1 != null && user2 != null) {
            user1.friendIds.remove(Integer.valueOf(userId2));
            user2.friendIds.remove(Integer.valueOf(userId1));
            System.out.println("Friend connection removed.");
        } else {
            System.out.println("One or both users not found.");
        }
    }

    // Display all friends of a user
    public void displayFriends(int userId) {
        User user = findUserById(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        System.out.println("Friends of " + user.name + ":");
        for (int fid : user.friendIds) {
            User friend = findUserById(fid);
            if (friend != null) {
                System.out.println("ID: " + friend.userId + ", Name: " + friend.name);
            }
        }
    }

    // Find mutual friends
    public void findMutualFriends(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }
        System.out.println("Mutual Friends:");
        for (int fid : user1.friendIds) {
            if (user2.friendIds.contains(fid)) {
                User friend = findUserById(fid);
                if (friend != null) {
                    System.out.println("ID: " + friend.userId + ", Name: " + friend.name);
                }
            }
        }
    }

    // Search user by name or ID
    public void searchUser(String keyword) {
        User current = head;
        boolean found = false;
        while (current != null) {
            if (current.name.equalsIgnoreCase(keyword) || String.valueOf(current.userId).equals(keyword)) {
                System.out.println("Found User - ID: " + current.userId + ", Name: " + current.name);
                found = true;
            }
            current = current.next;
        }
        if (!found) System.out.println("No matching user found.");
    }

    // Count friends for each user
    public void countAllFriends() {
        User current = head;
        while (current != null) {
            System.out.println("User: " + current.name + " has " + current.friendIds.size() + " friends.");
            current = current.next;
        }
    }
}

// Example usage
 class userdetails {
    public static void main(String[] args) {
        SocialNetwork sn = new SocialNetwork();
        sn.addUser(1, "Alice", 25);
        sn.addUser(2, "Bob", 30);
        sn.addUser(3, "Charlie", 28);

        sn.addFriend(1, 2);
        sn.addFriend(1, 3);
        sn.displayFriends(1);

        sn.findMutualFriends(2, 3);

        sn.searchUser("Alice");
        sn.countAllFriends();
    }
}
