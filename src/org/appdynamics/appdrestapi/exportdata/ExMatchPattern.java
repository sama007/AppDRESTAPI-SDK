/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.appdynamics.appdrestapi.exportdata;

import org.appdynamics.appdrestapi.resources.AppExportS;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gilbert.solorzano
 * 
 * L2_1
 * 
 */

public class ExMatchPattern {
    private String matchType,matchPattern;
    private boolean inverse;
    private int level=4;
    
    public ExMatchPattern(){}

    @XmlElement(name=AppExportS.MATCH_TYPE)
    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    @XmlElement(name=AppExportS.MATCH_PATTERN)
    public String getMatchPattern() {
        return matchPattern;
    }

    public void setMatchPattern(String matchPattern) {
        this.matchPattern = matchPattern;
    }

    @XmlElement(name=AppExportS.INVERSE)
    public boolean isInverse() {
        return inverse;
    }

    public void setInverse(boolean inverse) {
        this.inverse = inverse;
    }

    @XmlTransient
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    
    
    
    @Override
    public String toString(){
        StringBuilder bud = new StringBuilder();
        level++;
        bud.append(AppExportS.I[level]).append(AppExportS.MATCH_TYPE).append(AppExportS.VE).append(matchType);
        bud.append(AppExportS.I[level]).append(AppExportS.MATCH_PATTERN).append(AppExportS.VE).append(matchPattern);
        bud.append(AppExportS.I[level]).append(AppExportS.INVERSE).append(AppExportS.VE).append(inverse);
        level--;
        return bud.toString();
    }

    public String whatIsDifferent(ExMatchPattern obj){
        
        if(this.equals(obj)) return AppExportS._U;
        
        StringBuilder bud =new StringBuilder();
        level++;
        if(!matchType.equals(obj.getMatchType())){
            bud.append(AppExportS.L3).append(AppExportS.MATCH_TYPE);
            level++;
            bud.append(AppExportS.L3_1).append(AppExportS.SRC).append(AppExportS.VE).append(matchType);
            bud.append(AppExportS.L3_1).append(AppExportS.DEST).append(AppExportS.VE).append(obj.getMatchType());
            level--;
        }
        
        if(!matchPattern.equals(obj.getMatchPattern())){
            bud.append(AppExportS.L3).append(AppExportS.MATCH_PATTERN);
            level++;
            bud.append(AppExportS.L3_1).append(AppExportS.SRC).append(AppExportS.VE).append(matchPattern);
            bud.append(AppExportS.L3_1).append(AppExportS.DEST).append(AppExportS.VE).append(obj.getMatchPattern());
            level--;
        }
        
        if(inverse != obj.isInverse()){
            bud.append(AppExportS.L3).append(AppExportS.INVERSE);
            level++;
            bud.append(AppExportS.L3_1).append(AppExportS.SRC).append(AppExportS.VE).append(inverse);
            bud.append(AppExportS.L3_1).append(AppExportS.DEST).append(AppExportS.VE).append(obj.isInverse());
            level--;
        }
        level--;
        return bud.toString();
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.matchType != null ? this.matchType.hashCode() : 0);
        hash = 97 * hash + (this.matchPattern != null ? this.matchPattern.hashCode() : 0);
        hash = 97 * hash + (this.inverse ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ExMatchPattern other = (ExMatchPattern) obj;
        if ((this.matchType == null) ? (other.matchType != null) : !this.matchType.equals(other.matchType)) {
            return false;
        }
        if ((this.matchPattern == null) ? (other.matchPattern != null) : !this.matchPattern.equals(other.matchPattern)) {
            return false;
        }
        if (this.inverse != other.inverse) {
            return false;
        }
        return true;
    }
    
    
    
}

/*
            <ignore-logger-msg-patterns>
                <match-type>EQUALS</match-type>
                <match-pattern>bart</match-pattern>
                <inverse>false</inverse>
            </ignore-logger-msg-patterns>
 */