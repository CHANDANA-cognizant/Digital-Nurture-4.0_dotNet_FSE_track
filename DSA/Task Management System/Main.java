public class Main {
    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();

        taskList.addTask(new Task(1, "Design UI", "Pending"));
        taskList.addTask(new Task(2, "Build Backend", "In Progress"));
        taskList.addTask(new Task(3, "Write Tests", "Not Started"));

        System.out.println("All Tasks:");
        taskList.traverseTasks();

        System.out.println("\nSearching for Task with ID 2:");
        Task foundTask = taskList.searchTask(2);
        System.out.println(foundTask != null ? foundTask : "Task not found");

        System.out.println("\nDeleting Task with ID 2:");
        boolean isDeleted = taskList.deleteTask(2);
        System.out.println(isDeleted ? "Task deleted." : "Task not found.");

        System.out.println("\nTasks after deletion:");
        taskList.traverseTasks();
    }
}
