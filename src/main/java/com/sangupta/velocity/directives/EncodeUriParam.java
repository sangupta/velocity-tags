package com.sangupta.velocity.directives;

import java.io.IOException;
import java.io.Writer;

import org.apache.velocity.context.InternalContextAdapter;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.directive.Directive;
import org.apache.velocity.runtime.parser.node.Node;

import com.sangupta.jerry.util.AssertUtils;
import com.sangupta.jerry.util.UriUtils;

/**
 * Encode the given {@link String} param using
 * {@link UriUtils#encodeURIComponent(String)} method.
 * 
 * @author sangupta
 *
 */
public class EncodeUriParam extends Directive {

	@Override
	public String getName() {
		return "encodeURIComponent";
	}
	
	@Override
	public int getType() {
		return LINE;
	}
	
	@Override
	public boolean render(InternalContextAdapter context, Writer writer, Node node) throws IOException, ResourceNotFoundException, ParseErrorException, MethodInvocationException {
		String url = null;
		
		if(node.jjtGetChild(0) != null) {
			url = String.valueOf(node.jjtGetChild(0).value(context));
		}
		
		if(AssertUtils.isEmpty(url)) {
			return true;
		}
		
		writer.write(UriUtils.encodeURIComponent(url));
		return true;
	}

}
