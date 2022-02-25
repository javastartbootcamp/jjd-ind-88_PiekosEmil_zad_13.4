package pl.javastart.task;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CustomListTest {

    @Test
    public void shouldAddFewElements() {
        // given
        CustomList<String> customList = new CustomList<>();

        // when
        customList.add("a");
        customList.add("b");
        customList.add("c");

        // then
        assertThat(customList.size()).isEqualTo(3);

        assertThat(customList.get(0)).isEqualTo("a");
        assertThat(customList.get(1)).isEqualTo("b");
        assertThat(customList.get(2)).isEqualTo("c");
    }

    @Test
    public void shouldPrintAll() {
        // given
        CustomList<String> customList = new CustomList<>();

        // when
        customList.add("a");
        customList.add("b");
        customList.add("c");

        // then
        assertThat(customList.toString()).isEqualTo("[a, b, c]");
    }

    @Test
    public void shouldPrintAllCustomObjects() {
        // given
        CustomList<User> customList = new CustomList<>();
        customList.add(new User("Ania", 15));
        customList.add(new User("Marek", 33));
        customList.add(new User("Zofia", 28));

        // when
        String printedList = customList.toString();

        // then
        assertThat(printedList).isEqualTo("[Ania 15 lat, Marek 33 lat, Zofia 28 lat]");
    }

    @Test
    public void shouldAdd100Elements() {
        // given
        CustomList<Integer> customList = new CustomList<>();

        // when
        for (int i = 0; i < 100; i++) {
            customList.add(i + 1);
        }

        // then
        assertThat(customList.size()).isEqualTo(100);

        for (int i = 0; i < 100; i++) {
            assertThat(customList.get(i)).isEqualTo(i + 1);
        }
    }

    @Test
    public void shouldAddBetweenOtherElements() {
        // given
        CustomList<String> customList = new CustomList<>();
        customList.add("a");
        customList.add("b");
        customList.add("c");

        // when
        customList.add(1, "a1");

        // then
        assertThat(customList.size()).isEqualTo(4);
        String firstItem = customList.get(0);
        assertThat(firstItem).isEqualTo("a");
        assertThat(customList.get(1)).isEqualTo("a1");
        assertThat(customList.get(2)).isEqualTo("b");
        assertThat(customList.get(3)).isEqualTo("c");
    }

    @Test
    public void shouldAddToTheEnd() {
        // given
        CustomList<String> customList = new CustomList<>();
        customList.add("a");
        customList.add("b");
        customList.add("c");

        // when
        customList.add(3, "c1");

        // then
        assertThat(customList.size()).isEqualTo(4);
        assertThat(customList.get(0)).isEqualTo("a");
        assertThat(customList.get(1)).isEqualTo("b");
        assertThat(customList.get(2)).isEqualTo("c");
        assertThat(customList.get(3)).isEqualTo("c1");
    }

    @Test
    public void shouldRemoveItem() {
        // given
        CustomList<String> customList = new CustomList<>();
        customList.add("a");
        customList.add("b");
        customList.add("c");

        // when
        customList.remove(1);

        // then
        assertThat(customList.size()).isEqualTo(2);
        assertThat(customList.get(0)).isEqualTo("a");
        assertThat(customList.get(1)).isEqualTo("c");
    }

    @Test
    public void shouldRemoveItemAtTheEnd() {
        // given
        CustomList<String> customList = new CustomList<>();
        customList.add("a");
        customList.add("b");
        customList.add("c");

        // when
        customList.remove(2);

        // then
        assertThat(customList.size()).isEqualTo(2);
        assertThat(customList.get(0)).isEqualTo("a");
        assertThat(customList.get(1)).isEqualTo("b");
    }

}