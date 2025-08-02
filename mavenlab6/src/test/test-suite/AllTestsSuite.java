package com.maven6;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({Coursetest.class, OnlineCoursetest.class, OnSiteCoursetest.class})
public class AllTestsSuite {
}
