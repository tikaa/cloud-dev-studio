/*
* Copyright (c) 2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package org.wso2.developerstudio.codenvy.ext.appserver.server.project;

import com.codenvy.api.project.server.*;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.wso2.developerstudio.codenvy.ext.appserver.shared.AppServerExtConstants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Singleton
public class JAXWSProjectTypeExtension implements ProjectTypeExtension {

	private final ProjectType projectType;

	@Inject
	public JAXWSProjectTypeExtension(ProjectTypeDescriptionRegistry registry) {
		this.projectType = new ProjectType(AppServerExtConstants.WSO2_JAX_WS_PROJECT_ID,
		                                   AppServerExtConstants.WSO2_JAX_WS_PROJECT_NAME,
		                                   AppServerExtConstants.WSO2_APP_SERVER_PROJECT_CATEGORY_ID);
		registry.registerProjectType(this);
	}

	@Override
	public ProjectType getProjectType() {
		return projectType;
	}

	@Override
	public List<Attribute> getPredefinedAttributes() {
		final List<Attribute> list = new ArrayList<Attribute>();
		list.add(new Attribute(AppServerExtConstants.LANGUAGE,
		                       AppServerExtConstants.JAVA_LANGUAGE));
		list.add(new Attribute(AppServerExtConstants.BUILDER_NAME,
		                       AppServerExtConstants.MAVEN_BUILDER));
		list.add(new Attribute(AppServerExtConstants.RUNNER_NAME,
		                       AppServerExtConstants.WSO2_APP_SERVER_RUNNER_NAME));
		return list;
	}

	@Override public Builders getBuilders() {
		return null;
	}

	@Override public Runners getRunners() {
		return null;
	}

	@Override
	public List<ProjectTemplateDescription> getTemplates() {
		return Arrays.asList(new ProjectTemplateDescription("zip",
		                                                    "WSO2 SAMPLE JAXWS SERVICE PROJECT",
		                                                    "This is a simple sample JAXWS service project.",
		                                                    "templates/JAXWSServiceSample.zip"));
	}

	@Override public Map<String, String> getIconRegistry() {
		return null;
	}
}
