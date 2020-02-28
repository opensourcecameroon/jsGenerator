package cm.opensource.jsgenerator;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;

import cm.opensource.jsgenerator.model.JsElement;

public class Main {

	public static String globalString = new String();

	private static List<String> usedTags = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String sampleHtml = "" + "<!-- Button trigger modal -->\n"
				+ "<button type=\"button\" class=\"btn btn-primary\" data-toggle=\"modal\" data-target=\"#exampleModal\">\n"
				+ "  Launch demo modal\n" + "</button>\n" + "\n" + "<!-- Modal -->\n"
				+ "<div class=\"modal fade\" id=\"exampleModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n"
				+ "  <div class=\"modal-dialog\" role=\"document\">\n" + "    <div class=\"modal-content\">\n"
				+ "      <div class=\"modal-header\">\n"
				+ "        <h5 class=\"modal-title\" id=\"exampleModalLabel\">Modal title</h5>\n"
				+ "        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n"
				+ "          <span aria-hidden=\"true\">&times;</span>\n" + "        </button>\n" + "      </div>\n"
				+ "      <div class=\"modal-body\">\n" + "        ...\n" + "      </div>\n"
				+ "      <div class=\"modal-footer\">\n"
				+ "        <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>\n"
				+ "        <button type=\"button\" class=\"btn btn-primary\">Save changes</button>\n" + "      </div>\n"
				+ "    </div>\n" + "  </div>\n" + "</div>";

		Element doc = Jsoup.parse(sampleHtml, "", Parser.xmlParser());
		System.out.println(parseElement(doc));

	}

	private static String parseElement(Element element) {
		String _return = new String();
//		System.out.println("I directly have: " + element.children().size() + " children\n\n");
		for (Element child : element.children()) {
			_return += parseElement(child) + "\n";
			JsElement parent = new JsElement(child);
			_return += parent.parse(usedTags);
			String appends = parent.appendChild();
			if (!appends.equals(new String()))
				_return += appends;
		}

		return _return;
	}

}
