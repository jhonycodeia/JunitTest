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
