package net.sf.anathema.character.equipment.impl.creation.model;

import net.sf.anathema.character.equipment.creation.model.stats.IWeaponDamageModel;
import net.sf.anathema.character.generic.health.HealthType;
import net.sf.anathema.lib.control.change.ChangeControl;
import net.sf.anathema.lib.control.change.IChangeListener;
import net.sf.anathema.lib.data.Range;
import net.sf.anathema.lib.workflow.intvalue.IIntValueModel;
import net.sf.anathema.lib.workflow.intvalue.RangedIntValueModel;

public class WeaponDamageModel implements IWeaponDamageModel {

  private final ChangeControl changeControl = new ChangeControl();
  private final IIntValueModel damageModel;
  private final IIntValueModel minDamageModel;
  private HealthType healthType = HealthType.Lethal;

  public WeaponDamageModel() {
	damageModel = new RangedIntValueModel(new Range(0, Integer.MAX_VALUE), 0);
	minDamageModel = new RangedIntValueModel(new Range(0, Integer.MAX_VALUE), 1);
  }
  
  public IIntValueModel getDamageModel() {
	return damageModel;
  }
  
  public IIntValueModel getMinDamageModel() {
	return minDamageModel;
  }

  public HealthType getHealthType() {
    return healthType;
  }

  public void addHealthTypeChangeListener(IChangeListener listener) {
    changeControl.addChangeListener(listener);
  }

  public void setHealthType(HealthType healthType) {
    if (this.healthType == healthType) {
      return;
    }
    this.healthType = healthType;
    changeControl.fireChangedEvent();
  }
}