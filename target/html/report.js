$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Download.feature");
formatter.feature({
  "line": 1,
  "name": "Download section",
  "description": "In order to use Selenium in my project, I want to download Selenium language bindings",
  "id": "download-section",
  "keyword": "Feature"
});
formatter.before({
  "duration": 2709559659,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Python binding download link check",
  "description": "",
  "id": "download-section;python-binding-download-link-check",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "I am on the Selenium homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I click Download tab",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I should see Java download link on Download page",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.I_am_on_the_Selenium_homepage()"
});
formatter.result({
  "duration": 703268086,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.downloadtab()"
});
formatter.result({
  "duration": 111181,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.javaPage()"
});
formatter.result({
  "duration": 40196,
  "status": "passed"
});
formatter.after({
  "duration": 88517,
  "status": "passed"
});
formatter.uri("Download_Copy.feature");
formatter.feature({
  "line": 1,
  "name": "Download section",
  "description": "In order to use Selenium in my project, I want to download Selenium language bindings",
  "id": "download-section",
  "keyword": "Feature"
});
formatter.before({
  "duration": 1156628217,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Java binding download link check",
  "description": "",
  "id": "download-section;java-binding-download-link-check",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "I am on the Selenium homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I click Download tab",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I should see Java download link on Download page",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.I_am_on_the_Selenium_homepage()"
});
formatter.result({
  "duration": 341124427,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.downloadtab()"
});
formatter.result({
  "duration": 50887,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitions.javaPage()"
});
formatter.result({
  "duration": 32927,
  "status": "passed"
});
formatter.after({
  "duration": 20526,
  "status": "passed"
});
});