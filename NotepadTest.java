import org.junit.AfterClass;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class NotepadTest {

    @Test
    public void testCreateHeadline() {
    Notepad notepad = new Notepad();
    String head = "title1";
    String txt = "text1";
    notepad.create(head, txt);
    assertEquals(notepad.getArr()[0].getHeadline(), head);
    }

    @Test
    public void testCreateText() {
        Notepad notepad = new Notepad();
        String head = "title1";
        String txt = "text1";
        notepad.create(head, txt);
        assertEquals(notepad.getArr()[0].getText(), txt);
    }

    @Test
    public void testArrayExtends() {
        Notepad notepad = new Notepad();
        for(int i=0; i<11; i++) {
            notepad.create("this is headline", "this is text");
        }
        assertEquals(notepad.getArr().length, 20);
    }

    @Test
    public void testDeleteSizeDecreases() {
        String head1 = "head1";
        String head2 = "head2";
        String head3 = "head3";
        String text1 = "text1";
        String text2 = "text2";
        String text3 = "text3";
        Notepad notepad = new Notepad();
        notepad.create(head1, text1);
        notepad.create(head2, text2);
        notepad.create(head3, text3);
        int sizeBefore = notepad.getLastEmpty();
        notepad.delete(2);
        int sizeAfter = notepad.getLastEmpty();
        assertEquals(sizeBefore-1, sizeAfter);
    }

    @Test
    public void testEditHeadline() {
        Notepad notepad = new Notepad();
        String head = "title1";
        String txt = "text1";
        notepad.create(head, txt);
        notepad.edit(1,"helloHeadline","helloText");
        assertEquals(notepad.getArr()[0].getHeadline(), "helloHeadline");
    }
}