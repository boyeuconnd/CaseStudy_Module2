package codegym.controller.regexsearch;

import codegym.controller.impl.ISearch;
import codegym.model.Product;
import codegym.storage.ProductList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexSearch implements IRegexSearch {
//    private ISearch iSearch;
//    public RegexSearch(ISearch iSearch) {
//        this.iSearch = iSearch;
//    }

    @Override
    public boolean regexSearch(String inputName, String checkName) {
        String regex = this.createRegex(inputName);
        Pattern namePattern = Pattern.compile(regex);
        Matcher matcher = namePattern.matcher(checkName);
        return matcher.matches();
    }
    private String createRegex(String input){
        HashMap checkMap = this.createAlphabet();
        String stringIn = input.toLowerCase();
        String stringOut = new String();
        for (int i=0;i<stringIn.length();i++){
            Character tempChar = stringIn.charAt(i);
            if(checkMap.containsKey(tempChar)){
                Object replacement = checkMap.get(tempChar);
                stringOut+=replacement.toString();
            }else stringOut+=tempChar;

        }
        return stringOut+=".*";


    }
    private HashMap<Character,String> createAlphabet(){
        HashMap<Character,String> alphabet = new HashMap<>();
        alphabet.put('a',"[a|A]");
        alphabet.put('b',"[b|B]");
        alphabet.put('c',"[c|C]");
        alphabet.put('d',"[d|D]");
        alphabet.put('e',"[e|E]");
        alphabet.put('f',"[f|F]");
        alphabet.put('g',"[g|G]");
        alphabet.put('h',"[h|H]");
        alphabet.put('i',"[i|I]");
        alphabet.put('j',"[j|J]");
        alphabet.put('k',"[k|K]");
        alphabet.put('l',"[l|L]");
        alphabet.put('m',"[m|M]");
        alphabet.put('n',"[n|N]");
        alphabet.put('o',"[o|O]");
        alphabet.put('p',"[p|P]");
        alphabet.put('q',"[q|Q]");
        alphabet.put('r',"[r|R]");
        alphabet.put('s',"[s|S]");
        alphabet.put('t',"[t|T]");
        alphabet.put('u',"[u|U]");
        alphabet.put('v',"[v|V]");
        alphabet.put('w',"[w|W]");
        alphabet.put('x',"[x|X]");
        alphabet.put('y',"[y|Y]");
        alphabet.put('z',"[z|Z]");
        alphabet.put(' ',"\\s*");
        return alphabet;
    }


}
