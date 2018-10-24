//Goal is to enter HTML and get the JS equivalent of it... ( not like some fucking online sites do it...")

package interfaces;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import models.JsElement;

public class Main {
	
	public static String globalString = new String();

	public static void main(String[] args) {
		String sampleHtml = "<div class=\"card\" style=\"width: 18rem;\">\n" + 
				"  <img class=\"card-img-top\" src=\".../100px180/\" alt=\"Card image cap\"></img>\n" + 
				"  <div class=\"card-body\">\n" + 
				"    <h5 class=\"card-title\">Card title</h5>\n" + 
				"    <p class=\"card-text\">Some quick example text to build on the card title and make up the bulk of the card's content.</p>\n" + 
				"    <a href=\"#\" class=\"btn btn-primary\">Go somewhere</a>\n" + 
				"  </div>\n" + 
				"</div>";
		
		Element doc = Jsoup.parse(sampleHtml, "", Parser.xmlParser());
		System.out.println(parseElement(doc));
		
	}
	
	private static String parseElement(Element element) {
		String _return = new String();
//		System.out.println("I directly have: " + element.children().size() + " children\n\n");
		for(Element child : element.children()) {
			_return += parseElement(child);
			JsElement parent = new JsElement(child);
			_return += parent.parse();
			String appends = parent.appendChild();
			if(!appends.equals(new String()))
				_return += appends;
		}
		
		return _return;
	}
}