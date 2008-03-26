package net.sf.anathema.charm.cards

import org.custommonkey.xmlunit.DifferenceListener
import org.w3c.dom.Node

	
  int differenceFound(Difference difference){
    Node node = difference.getTestNodeDetail().getNode()
    if (node.getParentNode().getParentNode() != null){
      return RETURN_IGNORE_DIFFERENCE_NODES_SIMILAR
    }
    RETURN_ACCEPT_DIFFERENCE
  }
  
  void 	skippedComparison(Node control, Node test) {
    //nothing to do
  }
}