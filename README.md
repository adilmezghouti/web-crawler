# Getting Started

### Requirements
* Java 13
* Maven 3

### Running the crawler
Here are the steps to follow to run the crawler:
* mvn clean compile package
* cd target
* java -jar WebCrawler-0.0.1-SNAPSHOT.jar "http://wiprodigital.com"
* You should find a file named report.json in the target folder. This file contains the information that our crawler was able to find.

### Running the tests
To run the tests, please use this command: mvn clean compile test

### Functional Requirements
The crawler should be limited to one domain. Given a starting URL – say http://wiprodigital.com - it should visit all pages within the domain, but not follow the links to external sites such as Google or Twitter.
The output should be a simple structured site map (this does not need to be a traditional XML sitemap - just some sort of output to reflect what your crawler has discovered) showing links to other pages under the same domain, links to external URLs, and links to static content such as images for each respective page.

### Non-Functional Requirements
Here are some of the non-functional requirements that we will take into consideration while building our crawler:
* Add Logging for debugging, monitoring and analysis
* Make the application configurable so we can tweak things without the need to re-compile and re-deploy the app
* Handle exceptions gracefully and make sure to report them accordingly
* Validate the input data
* Provide good test coverage to make things like maintainability, readibility, refactoring easy in the future 

### Components
Choosing Spring allowed us to build an app that is easily configurable, testable, scalable, and integrable.
Please note that we used interfaces for all our components to make is easy for us to provide alternative implementations
to address needs that might come up in the future.
Here are the components that will serve as the building blocks of our crawler:
* WebPage: This is a POJO that will have the information we need to make the processing and categorization of urls possible.
* Processor: This component will play the role of the conductor/maestro
* Parser: This component will take care of parsing the html pages and identify the different types of resources/links
* Crawler Queue: This will play the role of a shared queue to make it easy to process pages
* Processed Pages: This plays the role of a shared list/collection that will be used to collect the results of our crawler
* Reporter: This component will read the results from the processed pages list and write it to a json file.
The file will have the following categories:
  * Internal Urls
  * External Urls
  * Static Content Urls
  * Errored Urls
  
### Enhancements
There are still a lot of things we can do to make our crawler better:
* Make our crawler scalable by making it multi-threaded
* Make the parsing of urls better by taking into consideration things like url parameters
* Add support  for generating reports in other formats like csv, xml or even store it directly in a database
* Add more tests

