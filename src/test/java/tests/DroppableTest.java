package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.DroppablePage;

public class DroppableTest extends BaseTest {

    @Test
    public void testDragAndDrop() {
        DroppablePage droppablePage = new DroppablePage(getDriver());

        String beforeDroppableText = droppablePage
                .switchToDroppableFrame()
                .getDroppable();

        String afterDroppableText = droppablePage
                .dragAndDrop()
                .getDroppable();

        Assert.assertEquals(beforeDroppableText, "Drop here");
        Assert.assertEquals(afterDroppableText, "Dropped!");
    }
}
