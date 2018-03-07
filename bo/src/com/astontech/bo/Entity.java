package com.astontech.bo;

public class Entity extends BaseBO {

    private int EntityId;
    private String EntityName;


    public Entity() {}

    public Entity(int entityId, String entityName) {
        this.setEntityId(entityId);
        this.setEntityName(entityName);
    }


    public int getEntityId() {
        return EntityId;
    }

    public void setEntityId(int entityId) {
        EntityId = entityId;
    }

    public String getEntityName() {
        return EntityName;
    }

    public void setEntityName(String entityName) {
        EntityName = entityName;
    }
}
