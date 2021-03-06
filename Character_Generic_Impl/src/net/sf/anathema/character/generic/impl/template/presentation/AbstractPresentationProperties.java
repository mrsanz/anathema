package net.sf.anathema.character.generic.impl.template.presentation;

import net.sf.anathema.character.generic.template.ITemplateType;
import net.sf.anathema.character.generic.template.presentation.IPresentationProperties;

public abstract class AbstractPresentationProperties implements IPresentationProperties {

  private final ITemplateType templateType;

  public AbstractPresentationProperties(ITemplateType templateType) {
    this.templateType = templateType;
  }

  @Override
  public String getSmallCasteIconResource(String casteId, String editionId) {
    return getCharacterTypeId() + "Button" + casteId + "16.png"; //$NON-NLS-1$//$NON-NLS-2$
  }

  @Override
  public String getNewActionResource() {
    return "CharacterGenerator.NewCharacter." + getCharacterTypeId() + ".Name"; //$NON-NLS-1$ //$NON-NLS-2$
  }

  protected final String getCharacterTypeId() {
    return templateType.getCharacterType().getId();
  }

  @Override
  public String getCasteLabelResource() {
    return getCharacterTypeId() + ".Caste.Label"; //$NON-NLS-1$;
  }

  protected final ITemplateType getTemplateType() {
    return templateType;
  }
}