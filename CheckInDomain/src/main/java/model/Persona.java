package model;

import core.BusinessRuleValidationException;
import core.Entity;
import java.util.Date;
import java.util.UUID;
import value.objects.CIValue;
import value.objects.PersonNameValue;

public class Persona extends Entity {

  private PersonNameValue name;
  private PersonNameValue lastname;
  private CIValue ci;

  public Persona(String name, String lastname, String ci) throws BusinessRuleValidationException {

    this.id = UUID.randomUUID();
    this.name = new PersonNameValue(name);
    this.lastname = new PersonNameValue(lastname);
    this.ci = new CIValue(ci);
  }

  public Persona(
      UUID id, String name, String lastname, Date birthday, String ci, boolean needAssistance)
      throws BusinessRuleValidationException {
    this.id = id;
    this.name = new PersonNameValue(name);
    this.lastname = new PersonNameValue(lastname);
    this.ci = new CIValue(ci);
  }

  public String getName() {
    return name.getName();
  }

  public String getLastname() {
    return lastname.getName();
  }

  public String getCi() {
    return ci.getCi();
  }
}
