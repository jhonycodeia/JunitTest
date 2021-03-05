# JunitTest
Running
`mvn -U clean verify install -Djava.awt.headless=true -Dtest=MainTestSuite -DfailIfNoTests=false -Dmaven.test.failure.ignore=true`

##### Java doc



`@author name` Who wrote it

`@version version` What version for example 1.0

`@param name description` Information of Input of method

`@return description` Information of Output of method

`@throws classname description` Information of mistakes or exception of method

`@since JDK1.8` Information about what version support of method

`@deprecated description` Indicates should no longer use ser or is not supported

`@see #field` reference

`@see #Constructor(Type, Type...)` reference

`@see #method(Type, Type...)` reference

`@see Class` reference

`@see Class#field` reference

`@see Class#Constructor(Type, Type...)` reference

`@see Class#method(Type, Type,...)` reference

`@see package.Class` reference

`@see package.Class#field` reference

`@see package.Class#Constructor(Type, Type...)` reference

`@see package.Class#method(Type, Type,...)`reference

`@see package` reference

`{@code offset}` Code inline

`{@link java.awt.Panel class}` uses the same nomenclature as `@see`

> Example


```
private static final String campo = "Variable statica de doc";	
	
	/**Method in charge of encrypting a name with code received as hash
	 * {@value #campo} reference {@link java.lang.String String}
	 * @param name String text
	 * @param code String hash
	 * @return {@code String} encoded according to the received {@code code}
	 * @throws NullPointerException if {@code name} is equal null
	 * @throws ParseException if {@code code} is equal null
	 * @since  JDK1.8
	 * @author jsarria
	 * @see java.lang.String
	 * @category Big-O(1)
	 */
	private static String encodeCapitalize(String name, String code) throws NullPointerException,ParseException {
```


### References
- JUnit - https://junit.org/junit5/docs/current/user-guide/
- AssertJ - https://joel-costigliola.github.io/assertj/
- Mockito - https://github.com/mockito/mockito/wiki/FAQ
- JsonPath - https://github.com/json-path/JsonPath
- Setting up JUnit 5 with Mockito and Spring Boot 2.0 - https://medium.com/@dSebastien/using-junit-5-with-spring-boot-2-kotlin-and-mockito-d5aea5b0c668
- Good Unit Testing 
  - https://github.com/mockito/mockito/wiki/How-to-write-good-tests
  - FIRST. https://pragprog.com/magazines/2012-01/unit-tests-are-first
  - Patterns - http://xunitpatterns.com
- Mocking Static, Private Methods and Constructors 
  - https://github.com/in28minutes/MockitoTutorialForBeginners/blob/master/Step15.md
  - https://github.com/in28minutes/MockitoTutorialForBeginners/tree/master/src/test/java/com/in28minutes/powermock

