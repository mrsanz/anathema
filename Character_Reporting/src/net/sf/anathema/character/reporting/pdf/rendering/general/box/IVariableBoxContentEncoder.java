package net.sf.anathema.character.reporting.pdf.rendering.general.box;

import net.sf.anathema.character.reporting.pdf.content.ReportContent;
import net.sf.anathema.character.reporting.pdf.rendering.graphics.SheetGraphics;

public interface IVariableBoxContentEncoder extends IBoxContentEncoder {

  public float getRequestedHeight(SheetGraphics graphics, ReportContent content, float width);
}
