/*
 * This file is generated by jOOQ.
*/
package com.jooq.data;


import com.jooq.data.tables.Locations;
import com.jooq.data.tables.Organizations;
import com.jooq.data.tables.Persons;
import com.jooq.data.tables.Test;
import com.jooq.data.tables.Urls;

import javax.annotation.Generated;


/**
 * Convenience access to all tables in public
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>public.locations</code>.
     */
    public static final Locations LOCATIONS = com.jooq.data.tables.Locations.LOCATIONS;

    /**
     * The table <code>public.organizations</code>.
     */
    public static final Organizations ORGANIZATIONS = com.jooq.data.tables.Organizations.ORGANIZATIONS;

    /**
     * The table <code>public.persons</code>.
     */
    public static final Persons PERSONS = com.jooq.data.tables.Persons.PERSONS;

    /**
     * The table <code>public.test</code>.
     */
    public static final Test TEST = com.jooq.data.tables.Test.TEST;

    /**
     * The table <code>public.urls</code>.
     */
    public static final Urls URLS = com.jooq.data.tables.Urls.URLS;
}
