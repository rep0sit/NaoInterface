package speech.main;
import static naointerface.utils.Constants.LINE_BREAK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.aldebaran.qi.CallError;
import com.aldebaran.qi.Session;
import com.aldebaran.qi.helper.proxies.ALMemory;
import com.aldebaran.qi.helper.proxies.ALSpeechRecognition;

class SpeechRecognitionImpl implements SpeechRecognition{
	
	private final String userName = "User";
	private final Session session;
	
	private Set<String> voca = new HashSet<>();
	private ALSpeechRecognition asr;
	private ALMemory mem;
	public SpeechRecognitionImpl(Session session) {
		this.session = session;
		if(session != null) {
			try {
				asr = new ALSpeechRecognition(session);
				mem = new ALMemory(session);
				asr.setVisualExpression(true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}
	
	
	

	@Override
	public String toString() {
		List<String> vocList = voca.stream().sorted(String.CASE_INSENSITIVE_ORDER).collect(Collectors.toList());
		StringBuilder sb = new StringBuilder();
		int i = 0;
		sb.append("This instance of SpeechRecognition knows " + voca.size() + " words:").append(LINE_BREAK);
		for(String s : vocList) {
			sb.append("Word#").append(++i).append(": ").append(s).append(LINE_BREAK);
		}
		
		
		return sb.toString();
	}
	
	private void actualizeVocs() {
		if(session != null) {
			try {
				asr.setVocabulary(voca.stream().collect(Collectors.toList()), false);
			} catch (CallError | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * Takes a String, splits it by " " and returns the result as a Set.<br>
	 * So if the String is "a b", <br>
	 * The result will include two elements {a,b}.<br>
	 * But the String "a a a" <br>
	 * will just include one element {a}.
	 * 
	 * @param c
	 * @return
	 */
	private Set<String> stringToWordSet(String s){
		Set<String> set = new HashSet<>();
		String[] sAry = s.split(" ");
		set.addAll(Arrays.asList(sAry));
		return set;
	}
	
	
	
	@Override
	public void addVocabulary(Collection<String> voca) {
		for(String s : voca) {
			this.voca.addAll(stringToWordSet(s));
		}
	
		actualizeVocs();
	}

	@Override
	public void addVocabulary(String...vocas) {
		addVocabulary(Arrays.asList(vocas));
	}




	@Override
	public Set<String> getVocabulary() {
		Iterator<String> it = voca.iterator();
		Set<String> ret = new HashSet<>();
		
		while(it.hasNext()) {
			ret.add(it.next());
		}
		return ret;
	}




	@Override
	public void clearVocabulary() {
		voca.clear();
		actualizeVocs();
		
	}




	
	
}
