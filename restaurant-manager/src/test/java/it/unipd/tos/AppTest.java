////////////////////////////////////////////////////////////////////
// [Pardeep] [Singh] [1143264]
////////////////////////////////////////////////////////////////////
package it.unipd.tos;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    /**
     * Rigourous Test :-)
     */
    @Test
    public void AppTestMainMethod_AnswerTrue()
    {
        App app = new App();
        String[] strings = new String[2];
        App.main(strings);
        assertTrue(true);
    }
}
