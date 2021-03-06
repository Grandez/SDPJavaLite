/**
 * Lista de variables
 */
package com.jgg.sdp.parser.base.symbol;

import java.util.ArrayList;

public class SymbolExtList {
	private ArrayList<SymbolExt> lista = new ArrayList<SymbolExt>();

    public SymbolExtList (SymbolExt v) {
        if (v != null) lista.add(v);
    }

	public SymbolExtList add(SymbolExt v) {
		if (v != null) lista.add(v);
		return this;
	}
	
    public ArrayList<SymbolExt> getVarList() {
        return lista;
    }

    public int getNumSymbols() {
    	return lista.size();
    }
    
    public SymbolExt getSymbol() {
    	return getSymbol(0);
    }
    
    public SymbolExt getSymbol(int index) {
    	return lista.get(index);
    }
}
