package speech.main;
import static naointerface.utils.Constants.LINE_BREAK;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.aldebaran.qi.CallError;
import com.aldebaran.qi.Session;
import com.aldebaran.qi.helper.proxies.ALSpeechRecognition;

import speech.utils.Words;

class SpeechRecognitionImpl implements SpeechRecognition{
	
	private final String userName = "User";
	private final Session session;
	
	private Set<String> voca = new HashSet<>();
	private ALSpeechRecognition asr;
	public SpeechRecognitionImpl(Session session) {
		this.session = session;
		if(session.isConnected()) {
			try {
				asr = new ALSpeechRecognition(session);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		addVocabulary(Words.DIGITS);
	
	}
	
	
	

	@Override
	public String toString() {
		List<String> vocList = voca.stream().sorted(String.CASE_INSENSITIVE_ORDER).collect(Collectors.toList());
		//vocList.sort(String.CASE_INSENSITIVE_ORDER);
		
		
		StringBuilder sb = new StringBuilder();
		int i = 0;
		sb.append("This instance of SpeechRecognition knows " + voca.size() + " words:").append(LINE_BREAK);
		for(String s : vocList) {
			sb.append("Word#").append(++i).append(": ").append(s).append(LINE_BREAK);
		}
		
		
		return sb.toString();
	}
	
	private void actualizeVocs() {
		
		try {
			asr.setVocabulary(voca.stream().collect(Collectors.toList()), false);
		} catch (CallError | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addVocabulary(Collection<String> voca) {
		this.voca.addAll(voca);
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




	
	
}
