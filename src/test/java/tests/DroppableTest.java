package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.DroppablePage;

public class DroppableTest extends BaseTest {

    @Test
    public void testDragAndDrop() {
        String droppedHereText = new DroppablePage(getDriver())
                .switchToDroppableFrame()
                .dragAndDrop()
                .getDroppedHere();

        Assert.assertEquals(droppedHereText, "Dropped!");
    }
}
