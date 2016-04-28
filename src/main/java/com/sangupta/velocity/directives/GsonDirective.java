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
import com.sangupta.jerry.util.GsonUtils;

public class GsonDirective extends Directive {

	@Override
	public String getName() {
		return "gson";
	}
	
	@Override
	public int getType() {
		return LINE;
	}
	
	@Override
	public boolean render(InternalContextAdapter context, Writer writer, Node node) throws IOException, ResourceNotFoundException, ParseErrorException, MethodInvocationException {
		Object object = null;
		
		if(node.jjtGetChild(0) != null) {
			object = node.jjtGetChild(0).value(context);
		}
		
		if(AssertUtils.isEmpty(object)) {
			return true;
		}
		
		writer.write(GsonUtils.getGson().toJson(object));
		return true;
	}

}
