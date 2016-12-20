package my.nhorushko.requestcmd.pr.testutils;

import my.nhorushko.requestcmd.pr.view.View;
import org.mockito.ArgumentCaptor;

import static org.mockito.Mockito.verify;

/**
 * Created by Nikol on 12/20/2016.
 */
public class TestUtils {
    public static String readConsoleView(View view){
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(view).write(captor.capture());
        return captor.getAllValues().toString();
    }
}
