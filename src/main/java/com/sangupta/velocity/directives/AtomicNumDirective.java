package com.sangupta.velocity.directives;

import java.io.IOException;
import java.io.Writer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.velocity.context.InternalContextAdapter;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.directive.Directive;
import org.apache.velocity.runtime.parser.node.Node;

public class AtomicNumDirective extends Directive {

	@Override
	public String getName() {
		return "atomicNum";
	}
	
	@Override
	public int getType() {
		return LINE;
	}
	
	@Override
	public boolean render(InternalContextAdapter context, Writer writer, Node node) throws IOException, ResourceNotFoundException, ParseErrorException, MethodInvocationException {
		if(node.jjtGetChild(0) == null) {
			return true;
		}
		
		Object obj = node.jjtGetChild(0).value(context);
		if(obj == null) {
			return true;
		}

		String value = null;
		
		if(obj instanceof AtomicInteger) {
			value = String.valueOf(((AtomicInteger) obj).get());
		} else if(obj instanceof AtomicLong) {
			value = String.valueOf(((AtomicLong) obj).get());
		}
		
		if(value != null) {
			writer.write(value);
		}
		
		return true;
	}
	
}
