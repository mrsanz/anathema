package net.sf.anathema.charm.cards

import groovy.xml.MarkupBuilder

	
  def write(ICharm[] charms){
    def writer = new StringWriter()
    def xml = new MarkupBuilder(writer)
    xml.cards(){
      charms.each{charm->
        card(){
          name(charm.getId())
        }
      }
    }
    writer.toString()    
  }
}