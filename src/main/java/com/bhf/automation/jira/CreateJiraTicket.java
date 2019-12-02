package com.bhf.automation.jira;

import org.testng.ITestResult;

import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.Field;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.JiraClient;
import net.rcarz.jiraclient.JiraException;

public class CreateJiraTicket {

	BasicCredentials creds = new BasicCredentials("batman", "pow! pow!");
	JiraClient jira = new JiraClient("<JiraUrl>", creds);

	public void createNewJiraIssue(ITestResult result, String projectName, String defectType, String defectSummary,
			String defectDescription, String defectReporter, String defectAssignee) {
		try {
			if (result.getStatus() == ITestResult.FAILURE) {

				/* Create new issue */
				Issue newIssue = jira.createIssue(projectName, defectType).field(Field.SUMMARY, defectSummary)
						.field(Field.DESCRIPTION, defectDescription).field(Field.REPORTER, defectReporter)
						.field(Field.ASSIGNEE, defectAssignee).execute();
			}
		} catch (JiraException ex) {
			System.err.println(ex.getMessage());

			if (ex.getCause() != null)
				System.err.println(ex.getCause().getMessage());
		}
	}

}
