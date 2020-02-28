package cm.opensource.jsgenerator.model;

import java.util.List;

import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;

public class JsElement {

	private Element element = null;

	public JsElement() {

	}

	public JsElement(Element element) {
//		System.out.println("Element: " + element);
		this.element = element;
	}

//	WITH USED TAGS LIST
	public String parse(List<String> usedTags) {
		// atrributes
		Attributes attributes = this.element.attributes();
		// text nodes
		List<TextNode> innerHTML = this.element.textNodes();

		// search tag name
		for (String _tag : usedTags) {
			if (_tag.equals(this.element.tagName()))
				this.element.tagName(this.element.tagName() + "_");
		}

		// tag name
		String tag = this.element.tagName();
		usedTags.add(tag);

		// generation of code
		String _return = "var " + tag + " = document.createElement(\"" + tag.replace("_", "") + "\");\n";

		for (Attribute attribute : attributes) {
			_return += tag + ".setAttribute(\"" + attribute.getKey() + "\", \"" + attribute.getValue() + "\");\n";
		}

		for (TextNode textNode : innerHTML) {
			if (!textNode.isBlank())
				_return += tag + ".appendChild(document.createTextNode(\""
						+ textNode.toString().replace("\n", "").trim() + "\"));\n";
		}

		return _return;

	}

//	WITHOUT USED TAGS LIST
	public String parse() {
		// atrributes
		Attributes attributes = this.element.attributes();
		// text nodes
		List<TextNode> innerHTML = this.element.textNodes();
		// tag name
		String tag = this.element.tagName();

		// generation of code
		String _return = "var " + tag + " = document.createElement(\"" + tag + "\");\n";

		for (Attribute attribute : attributes) {
			_return += tag + ".setAttribute(\"" + attribute.getKey() + "\", \"" + attribute.getValue() + "\");\n";
		}

		for (TextNode textNode : innerHTML) {
			if (!textNode.isBlank())
				_return += tag + ".appendChild(document.createTextNode(\""
						+ textNode.toString().replace("\n", "").trim() + "\"));\n";
		}

		return _return;

	}

	public String appendChild() {
		String _return = new String();
//		return this.element.children().size() > 0 ? this.element.tagName() + ".appendChild("+this.element.child(0).tagName()+");\n" : new String();
		if (this.element.children().size() > 0) {
			for (Element child : this.element.children()) {
				_return += this.element.tagName() + ".appendChild(" + child.tagName() + ");\n";
			}
		}

		return _return;
	}

}
