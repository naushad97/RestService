package com.cts.res.xml.response;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.thoughtworks.xstream.XStream;

@SuppressWarnings("deprecation")
public class XMLViewResolver extends MappingJackson2JsonView {

	private static final Logger LOGGER = LoggerFactory.getLogger(XMLViewResolver.class);

	private String contentType;
	private Set<String> renderedAttributes;

	public XMLViewResolver() {
		setContentType(contentType);
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) {
		Object value = filterModel(model);
		XStream xstream = new XStream();
		xstream.alias(value.getClass().getSimpleName(), value.getClass());
		String xmlStr = xstream.toXML(value);
		try {
			response.getWriter().write(xmlStr);
		} catch (IOException e) {
			LOGGER.error("Exception caught :",e.getMessage());
		}
	}

	@Override
	protected Object filterModel(Map<String, Object> model) {
		Object result = new Object();
		Set<String> mRenderedAttributes = !CollectionUtils.isEmpty(this.renderedAttributes) ? this.renderedAttributes : model.keySet();
		for (Map.Entry<String, Object> entry : model.entrySet()) {
			if (!(entry.getValue() instanceof BindingResult) && mRenderedAttributes.contains(entry.getKey())) {
				result = entry.getValue();
			}
		}
		return result;
	}
}
