////////////////////////////////////////////////////////////////////
// [Pardeep] [Singh] [1143264]
////////////////////////////////////////////////////////////////////
package it.unipd.tos;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Rigourous Test :-)
     */
    public void AppTestMainMethod_AnswerTrue()
    {
        App app = new App();
        String[] strings = new String[2];
        App.main(strings);
        assertTrue(true);
    }
}
