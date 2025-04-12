import java.util.ArrayList;

// Node class representing a text state
class TextState {
    String content;
    TextState prev, next;

    public TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}

// Doubly Linked List for Undo/Redo functionality
class TextEditor {
    private TextState head = null;
    private TextState current = null;
    private int size = 0;
    private final int MAX_HISTORY = 10;

    // Add new text state (e.g., after typing or an action)
    public void addState(String content) {
        TextState newState = new TextState(content);
        if (head == null) {
            head = newState;
            current = newState;
        } else {
            // Remove all states ahead of the current one (for redo reset)
            if (current.next != null) {
                current.next.prev = null;
                current.next = null;
            }
            current.next = newState;
            newState.prev = current;
            current = newState;
        }
        size++;
        trimHistory();
    }

    // Undo to the previous state
    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo performed.");
        } else {
            System.out.println("No more undo available.");
        }
    }

    // Redo to the next state
    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo performed.");
        } else {
            System.out.println("No more redo available.");
        }
    }

    // Display the current state
    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current State: " + current.content);
        } else {
            System.out.println("No content available.");
        }
    }

    // Trim history to maintain a max of MAX_HISTORY states
    private void trimHistory() {
        int count = 0;
        TextState temp = current;
        while (temp != null) {
            count++;
            temp = temp.prev;
        }
        if (count > MAX_HISTORY) {
            // Remove the oldest state
            temp = current;
            while (count > MAX_HISTORY) {
                temp = temp.prev;
                count--;
            }
            if (temp.prev != null) {
                temp.prev.next = null;
                temp.prev = null;
                head = temp; // New head after trimming
            }
        }
    }
}

// Example usage
class textediting {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");

        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        editor.redo();
        editor.displayCurrentState();

        editor.addState("Hello World Again!");
        editor.displayCurrentState();
    }
}
