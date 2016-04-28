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
import com.sangupta.jerry.util.ReadableUtils;

public class ReadableByteSizeDirective extends Directive {

	@Override
	public String getName() {
		return "readableByteSize";
	}
	
	@Override
	public int getType() {
		return LINE;
	}
	
	@Override
	public boolean render(InternalContextAdapter context, Writer writer, Node node) throws IOException, ResourceNotFoundException, ParseErrorException, MethodInvocationException {
		String size = null;
		
		if(node.jjtGetChild(0) != null) {
			size = String.valueOf(node.jjtGetChild(0).value(context));
		}
		
		if(AssertUtils.isEmpty(size)) {
			return true;
		}
		
		try {
			long sizeLong = Long.parseLong(size);
			String sizeAsString = ReadableUtils.getReadableByteCount(sizeLong);
			writer.write(sizeAsString);
		} catch(NumberFormatException e) {
			// eat up
		}
		
		return true;
	}
	
}
