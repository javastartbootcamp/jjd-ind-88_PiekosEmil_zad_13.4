package pl.javastart.task;

record User(String name, int age) {

    @Override
    public String toString() {
        return name + " " + age + " lat";
    }
}
