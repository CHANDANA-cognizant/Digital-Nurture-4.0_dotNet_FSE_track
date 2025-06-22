class TaskLinkedList {
    private Node head;

    // Add task at the end
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newNode;
        }
    }

    // Search task by taskId
    public Task searchTask(int id) {
        Node current = head;
        while (current != null) {
            if (current.task.taskId == id) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    // Traverse tasks
    public void traverseTasks() {
        if (head == null) {
            System.out.println("No tasks found.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    // Delete task by taskId
    public boolean deleteTask(int id) {
        if (head == null) return false;

        if (head.task.taskId == id) {
            head = head.next;
            return true;
        }

        Node current = head;
        Node prev = null;
        while (current != null && current.task.taskId != id) {
            prev = current;
            current = current.next;
        }

        if (current == null) return false;

        prev.next = current.next;
        return true;
    }
}
