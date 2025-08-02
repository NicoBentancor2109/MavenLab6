package com.maven6;


import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({Coursetest.class, OnlineCoursetest.class, OnSiteCoursetest.class})
@IncludeTags("smoke")  
@ExcludeTags("regression")  
public class TaggedTestsSuite {
    
}