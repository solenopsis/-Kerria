/*
 * Copyright (C) 2015 Scot P. Floess
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.solenopsis.keraiai.soap.credentials;

/**
 * Abstract base class for credentials.
 *
 * @author sfloess
 */
public abstract class AbstractCredentials implements Credentials {

    /**
     * Default constructor.
     */
    protected AbstractCredentials() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object object) {
        if (!(object instanceof Credentials)) {
            return false;
        }

        return hashCode() == object.hashCode() && getUserName().equals(((Credentials) object).getUserName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return getUserName().hashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final String getSecurityPassword() {
        return CredentialsUtils.computeSecurityPassword(getPassword(), getToken());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();

        sb.append("apiVersion       [").append(getApiVersion()).append("]\n");
        sb.append("password         [").append(getPassword()).append("]\n");
        sb.append("securityPassword [").append(getSecurityPassword()).append("]\n");
        sb.append("token            [").append(getToken()).append("]\n");
        sb.append("url              [").append(getUrl()).append("]\n");
        sb.append("userName         [").append(getUserName()).append("]");

        return sb.toString();
    }
}