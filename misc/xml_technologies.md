# XML Technologies

## xPath
- Selectors
    - `node` 
        - selects all the "node" nodes

    - `/node` 
        - selects all the specified nodes, starting from the virtual root node

    - `//node` 
        - selects all the specified nodes, starting from the current node, no matter where the searched node is place inside the document

    - `.` 
        - selects the current node

    - `..` 
        - selects the parrent of the current node

    - `@attr` 
        - select all the specified attributes

    - `//node[index]` 
        - selects the node from the index position
        - unlike a traditional programming language, the index of an array starts from 1

    - `*` 
        - matches any node

    - `@*` 
        - matches any attribute

    - `node1::node2` 
        - selects all the specified node2 nodes that are children of node1

    - `[]` 
        - specifies a condition

- Functions
    - `text()` 
        - selects all the text children of a node

    - `snode()` 
        - select all the children of a node

#
## XSLT
- XSLT elements can be accessed inside an XML if the following tag is present
    - `<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">`

- XSLT uses templates to define how an XML element should be rendered
    - `<xsl:template match=""></xsl:template>`

- any XSLT must have a template that matches the / element

     - `<xsl:apply-templates select="template_name"/>` 
        - applies the defined template for the children of a node

    - `<xsl:value-of select="parent/children"/>` 
        - extract data from a node 

    - `<xsl:for-each select="parent/children"></xsl:for-each>` 
        - iterates over a collection of nodes

    - `[]` 
        - specify a condition on a node
        - example: `<xsl:for-each select="parent/children[title="Welcome"]`

    - `<xsl:sort/>` 
        - sorts a list of nodes
        - should be used inside a `<xsl:for-each>` loop

    - `<xsl:if test="expression"> output </xsl:if>` 
        - displays an output if the expression is true
        - cannot be used as if/else - for that you should use choose

    - `<xsl:choose> <xsl:when test="expression> content </xsl:when> <xsl:otherwise> content </xsl:otherwise> </xsl:choose>`
        - works as a common switch
        - can be used for if/else expressions
        - multiple when expressions could be used

#
## XQuery
- it's built over XPath so every XPath expression is valid

- a XQuery file should always return something
    
- syntax
    - `declare namespace ns:="namespace";`
        - make sure that you don't have any typo in here

    - `declare option output:indent "yes";`
        - there are many other options that can be added

    - `declare variable $var := 3;` 
        - declaration of a variable and the assignment of its value

    - `declare variable $var as <type> external`  
        - loads a variable received as a command line parameter

    - `declare function local:functionName($parameter) as element() { return <ns:param>$parameter</ns:param> }`               
        - the element() parameter specifies the return type
        - to be used the functions should also be called inside a script, not only declared

    - `doc("file.xml")` 
        - used to open a xml file              
        - XPath expression can be used directly on document (ex: doc("file.xml")/bookstore/book/title)

    - `[]` 
        - it's called a predicate that limits the extracted data, just like an XPath condition
        - example: `doc("books.xml")/bookstore/book[price<30]`

    - `FLOWR expression`
        - comes from For, Let, Where, Order By and Return
            ```xquery
            for $x in $variable
            let $title = $x/title
            order by $x/year desc
            where $x/price < 30
            return $title
            ```

        - `For`
            - used to iterate over a collection of data
            
        - `Let`
            - assign a volatile variable, based on the current value of $

        - `Order By`
            - orders the resulted collection after a condition
            
        - `Where`
            - condition to determine if the element respects some parameters
            
        - `Return`
            - returns from a collection the selected entities which passes the conditions, into a sorted list
