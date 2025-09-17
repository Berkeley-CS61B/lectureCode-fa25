package lec7_lists4;

import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

/** This set of tests is not particularly exhaustive. For example,
 *  it doesn't test that you can add items to the list, then delete
 *  all of them, then add them back.
 */
public class AListTest {
    @Test
    public void testAddAndGet() {
        // We picked Integer as our type for Hug.
        AList<Integer> list = new AList<>();
        list.addLast(5);
        list.addLast(10);

        // List should be [5, 10]
        assertThat(list.get(0)).isEqualTo(5);
        assertThat(list.get(1)).isEqualTo(10);
    }

    @Test
    public void testGetLast() {
        AList list = new AList();
        list.addLast(7);
        list.addLast(14);
        list.addLast(21);

        // List should be [7, 14, 21]
        assertThat(list.getLast()).isEqualTo(21);
    }

    @Test
    public void testRemoveLast() {
        AList list = new AList();
        list.addLast(3);
        list.addLast(6);
        list.addLast(9);

        // First remove should return 9
        assertThat(list.removeLast()).isEqualTo(9);

        // And the list should be [3, 6] after that remove
        assertThat(list.get(0)).isEqualTo(3);
        assertThat(list.getLast()).isEqualTo(6);

        // List should be [3] after second remove, with 6 returned
        assertThat(list.removeLast()).isEqualTo(6);
        assertThat(list.removeLast()).isEqualTo(3);
    }

    @Test
    public void add200Items() {
        AList list = new AList();
        for (int i = 0; i < 200; i += 1) {
            list.addLast(i);
        }

        for (int i = 0; i < 200; i += 1) {
            assertThat(list.get(i)).isEqualTo(i);
        }
    }
}
