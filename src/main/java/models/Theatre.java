package models;

import java.util.List;

public class Theatre extends BaseModel{
    private String theatreName;
    private List<Screen> screens;
    private City city;              // access pattern
}
