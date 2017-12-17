package naointerface.main;
import static naointerface.main.Constants.LINE_BREAK;
import static naointerface.main.Constants.MILLISECONDS_PER_SECOND;
import static naointerface.main.Constants.NO_VOCABULARY;
import static naointerface.main.Constants.WORD_RECOGNIZED;
import static naointerface.main.Constants.normalize;

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
	private static final String NAO = "Nao"; 
	private boolean phrasesAllowed = false;
	
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
				
				this.addVocabulary(NAO);
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
				if(voca.isEmpty()) {
					voca.add(NAO);
				}
				
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
			if(phrasesAllowed) {
				this.voca.add(s);
			}else {
				this.voca.addAll(stringToWordSet(s));
			}
			
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



	@SuppressWarnings({ "rawtypes" })
	@Override
	public String recordWord(int seconds, boolean prob) {
		String retVal = NO_VOCABULARY;
		List sAry = new ArrayList();
		if (!voca.isEmpty()) {
			seconds = normalize(seconds, 0, 10);
			try {
				asr.subscribe(userName);
				System.out.println("Speech Recognition Engine started");
				Thread.sleep(seconds * MILLISECONDS_PER_SECOND);
				Object obj = mem.getData(WORD_RECOGNIZED);
				asr.unsubscribe(userName);

				sAry = (ArrayList) obj;
				
				
				String highestMatch = String.valueOf(sAry.get(0));
				String probVal = String.valueOf(sAry.get(1));
				
				double numericProbVal = Double.valueOf(probVal);
				
				
				retVal = numericProbVal < 0.0 ? "I couldn't understand what you just said. Maybe the word isn't in my vocabulary." :
					prob ? 
						"I understood the word: " + highestMatch + ", with a probability of " 
						+ probVal + "." : 
							highestMatch;

			} catch (CallError | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}
		return retVal;
	}




	@Override
	public void phrasesAllowed(boolean allowed) {
		phrasesAllowed = allowed;
		
	}


	
	
}
