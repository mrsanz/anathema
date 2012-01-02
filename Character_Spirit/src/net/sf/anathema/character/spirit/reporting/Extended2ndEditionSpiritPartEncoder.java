package net.sf.anathema.character.spirit.reporting;

import com.lowagie.text.pdf.BaseFont;
import net.sf.anathema.character.reporting.pdf.layout.extended.AbstractSecondEditionExaltPdfPartEncoder;
import net.sf.anathema.character.reporting.pdf.layout.extended.ExtendedEncodingRegistry;
import net.sf.anathema.character.reporting.pdf.rendering.general.NullBoxContentEncoder;
import net.sf.anathema.character.reporting.pdf.rendering.general.box.IBoxContentEncoder;
import net.sf.anathema.lib.resources.IResources;

public class Extended2ndEditionSpiritPartEncoder extends AbstractSecondEditionExaltPdfPartEncoder {

  private BaseFont baseFont;

  public Extended2ndEditionSpiritPartEncoder(IResources resources, ExtendedEncodingRegistry registry, int essenceMax) {
    super(resources, registry, essenceMax);
    this.baseFont = registry.getBaseFont();
  }

  // TODO: This should be properly edited out, not just nulled out.
  public IBoxContentEncoder getGreatCurseEncoder() {
    return new NullBoxContentEncoder();
  }

  @Override
  public IBoxContentEncoder getAnimaEncoder() {
    return new SpiritAnimaEncoderFactory(getResources()).createAnimaEncoder();
  }
}
