package net.sf.anathema.charm.cards;

import net.sf.anathema.charm.cards.CardsWriter
import net.sf.anathema.character.generic.magic.ICharm
import org.custommonkey.xmlunit.XMLUnit
import org.custommonkey.xmlunit.Diff
class CardsWriterTest extends GroovyTestCase {
  
	void testWritesEmptyCardsList() {
	    def xmlDiff = new Diff(new CardsWriter().write(null), CardXmlSamples.EMPTYLIST)
	    assert xmlDiff.similar()
	}
	
	void testWritesSingleCardForSingleCharm(){
	  XMLUnit.setIgnoreWhitespace(true)
	  String charmXml = new CardsWriter().write(new DummyCharm("testId"))
	  Diff diff = new Diff(charmXml, CardXmlSamples.SINGLECARD)
	  DifferenceListener listener = new LayerDifferenceListener() 
	  diff.overrideDifferenceListener(listener)
	  assert diff.similar()
	}
	
	void testMultipleCardsForMultipleObjects(){
	  XMLUnit.setIgnoreWhitespace(true)
	  ICharm[] charms  = [new DummyCharm("testId"), new DummyCharm("toastId")]
	  String charmXml = new CardsWriter().write(charms)
	  Diff diff = new Diff(charmXml, CardXmlSamples.MULTICARD)
	  DifferenceListener listener = new LayerDifferenceListener() 
	  diff.overrideDifferenceListener(listener)
	  assert diff.similar()
	}
	
	void testWritesIdInPlaceOfName(){
	  XMLUnit.setIgnoreWhitespace(true)
	  String charmXml = new CardsWriter().write(new DummyCharm("testId"))
	  assert new Diff(charmXml, CardXmlSamples.NAMED_CARD).similar()
	}
}