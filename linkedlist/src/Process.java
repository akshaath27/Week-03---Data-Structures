// Node class representing a process
class Process {
    int processId;
    int burstTime;
    int priority;
    int remainingTime;
    Process next;

    public Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.remainingTime = burstTime;
        this.next = null;
    }
}

// Circular Linked List Scheduler Class
class RoundRobinScheduler {
    private Process head = null;
    private Process tail = null;
    private int timeQuantum;

    public RoundRobinScheduler(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    // Add process at end
    public void addProcess(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            tail.next = head;
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head;
        }
    }

    // Remove process by ID
    public void removeProcess(int processId) {
        if (head == null) return;

        Process current = head, prev = tail;
        do {
            if (current.processId == processId) {
                if (current == head && current == tail) {
                    head = tail = null;
                } else {
                    if (current == head) head = head.next;
                    if (current == tail) tail = prev;
                    prev.next = current.next;
                }
                break;
            }
            prev = current;
            current = current.next;
        } while (current != head);
    }

    // Display processes
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }
        Process temp = head;
        System.out.println("Processes in Queue:");
        do {
            System.out.println("PID: " + temp.processId + ", Burst: " + temp.burstTime + ", Priority: " + temp.priority + ", Remaining: " + temp.remainingTime);
            temp = temp.next;
        } while (temp != head);
    }

    // Run round robin scheduling
    public void schedule() {
        if (head == null) return;

        int time = 0;
        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        int processCount = 0;

        Process current = head;
        while (head != null) {
            if (current.remainingTime > 0) {
                int execTime = Math.min(current.remainingTime, timeQuantum);
                System.out.println("Executing PID: " + current.processId + " for " + execTime + " units.");
                current.remainingTime -= execTime;
                time += execTime;

                if (current.remainingTime == 0) {
                    int turnaroundTime = time;
                    int waitingTime = turnaroundTime - current.burstTime;
                    totalWaitingTime += waitingTime;
                    totalTurnaroundTime += turnaroundTime;
                    System.out.println("Process " + current.processId + " completed. Turnaround: " + turnaroundTime + ", Waiting: " + waitingTime);
                    int completedId = current.processId;
                    current = current.next;
                    removeProcess(completedId);
                    processCount++;
                    continue;
                }
            }
            current = current.next;
        }

        System.out.println("\nAverage Waiting Time: " + (totalWaitingTime / (double) processCount));
        System.out.println("Average Turnaround Time: " + (totalTurnaroundTime / (double) processCount));
    }
}

// Example usage
 class robinround {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler(4);
        scheduler.addProcess(1, 10, 2);
        scheduler.addProcess(2, 5, 1);
        scheduler.addProcess(3, 8, 3);

        scheduler.displayProcesses();
        scheduler.schedule();
    }
}
