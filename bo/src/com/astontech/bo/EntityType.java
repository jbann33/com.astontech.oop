package com.astontech.bo;

public class EntityType extends BaseBO {

    //region PROPERTIES
    private int EntityTypeId;
    private String EntityTypeName;
    //endregion

    //region CONSTRUCTORS
    public EntityType () {}

    public EntityType(int entityTypeId, String entityTypeName) {
        this.setEntityTypeId(entityTypeId);
        this.setEntityTypeName(entityTypeName);
    }

    public EntityType(String entityTypeName) {
        this.setEntityTypeName(entityTypeName);
    }
    //endregion


    //region GETTERS & SETTERS
    public int getEntityTypeId() {
        return EntityTypeId;
    }

    public void setEntityTypeId(int entityTypeId) {
        EntityTypeId = entityTypeId;
    }

    public String getEntityTypeName() {
        return EntityTypeName;
    }

    public void setEntityTypeName(String entityTypeName) {
        EntityTypeName = entityTypeName;
    }
    //endregion

    public String test_method() {
        return "sub method";
    }
}
