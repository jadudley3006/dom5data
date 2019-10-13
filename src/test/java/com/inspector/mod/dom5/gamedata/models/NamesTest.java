package com.inspector.mod.dom5.gamedata.models;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;

class NamesTest {

    @Test
    void getHumanReadableName() {

        Assert.assertThat(Names.getHumanReadableName("mr"), is("magic resistance"));
        Assert.assertThat(Names.getHumanReadableName("unknown"), is("<-- unmapped description: unknown -->"));

    }
}