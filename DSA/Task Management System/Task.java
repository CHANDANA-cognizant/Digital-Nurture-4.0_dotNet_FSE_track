class Task {
    int taskId;
    String taskName;
    String status;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    public String toStrings() {
        return "Task ID: " + taskId + ", Name: " + taskName + ", Status: " + status;
    }
}
