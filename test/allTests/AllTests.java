package allTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	naointerface.utils.ConstantsTest.class,
	naointerface.main.SpeechRecognitionImplTest.class
	})
public class AllTests {

}
