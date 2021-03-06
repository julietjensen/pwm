/*
 * Password Management Servlets (PWM)
 * http://www.pwm-project.org
 *
 * Copyright (c) 2006-2009 Novell, Inc.
 * Copyright (c) 2009-2016 The PWM Project
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package password.pwm.http.servlet.peoplesearch;

import java.io.Serializable;
import java.util.List;

class OrgChartDataBean implements Serializable {
    private OrgChartReferenceBean parent;
    private OrgChartReferenceBean self;
    private List<OrgChartReferenceBean> children;

    public OrgChartReferenceBean getParent() {
        return parent;
    }

    public void setParent(final OrgChartReferenceBean parent) {
        this.parent = parent;
    }

    public OrgChartReferenceBean getSelf() {
        return self;
    }

    public void setSelf(final OrgChartReferenceBean self) {
        this.self = self;
    }

    public List<OrgChartReferenceBean> getChildren() {
        return children;
    }

    public void setChildren(final List<OrgChartReferenceBean> children) {
        this.children = children;
    }
}
